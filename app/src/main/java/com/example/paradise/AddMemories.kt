package com.example.paradise

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_memories2.*
import java.text.SimpleDateFormat
import java.util.*
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

@Suppress("DEPRECATION")
class AddMemories : AppCompatActivity(), View.OnClickListener {

    private val cal = Calendar.getInstance()
    private lateinit var dateSetListener : DatePickerDialog.OnDateSetListener
    private var path: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_memories2)

        dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR , year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }
        updateDateInView()

        et_user_date.setOnClickListener(this)
        iv_add_image.setOnClickListener(this)
        btn_insert_memory.setOnClickListener(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == GALLERY){
                if (data != null){
                    val contentURI = data.data
                    try {
                        val selectedImageBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                        path = saveImageToInternalStorage(selectedImageBitmap)
                        Log.i("Image path", ":: $path")
                        iv_add_image.setImageBitmap(selectedImageBitmap)
                    }catch (e:IOException){
                        e.printStackTrace()
                        Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.et_user_date ->{
                DatePickerDialog(this, dateSetListener,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }

            R.id.iv_add_image ->{
                choosePhotoFromGallery()
            }

            R.id.btn_insert_memory -> {
                when {
                    et_user_title.text.isNullOrEmpty() -> {
                        Toast.makeText(this, "Please enter a Title", Toast.LENGTH_SHORT).show()
                    }
                    et_user_desc.text.isNullOrEmpty() -> {
                        Toast.makeText(this, "Please enter a description", Toast.LENGTH_SHORT).show()
                    }
                    et_user_location.text.isNullOrEmpty() -> {
                        Toast.makeText(this, "Please enter a location", Toast.LENGTH_SHORT).show()
                    }
                    path == null -> {
                        Toast.makeText(this, "Please add a image", Toast.LENGTH_SHORT).show()
                    }
                    else ->{

                        val viewModel = ViewModelProvider(this).get(MemoriesViewModel::class.java)
                        viewModel.insertMemories(MemoriesTable(et_user_title.text.toString(),
                                et_user_desc.text.toString(), et_user_date.text.toString(),
                                path.toString(), et_user_location.text.toString()))
                        finish()
                    }
                }

            }
        }
    }

    private fun choosePhotoFromGallery() {
        Dexter.withActivity(this).withPermissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                if (p0!!.areAllPermissionsGranted()) {
                    val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(galleryIntent, GALLERY)
                }
            }

            override fun onPermissionRationaleShouldBeShown(p0: MutableList<PermissionRequest>?, p1: PermissionToken?) {
                Toast.makeText(this@AddMemories, "Turn on Storage permission for app settings", Toast.LENGTH_SHORT).show()
            }
        }).check()

    }

    private fun updateDateInView(){
        val formate = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(formate, Locale.getDefault())
        et_user_date.setText(sdf.format(cal.time).toString())
    }

    private fun saveImageToInternalStorage(bitmap: Bitmap): Uri {
        val wrapper = ContextWrapper(applicationContext)
        var file = wrapper.getDir(IMAGE_DIRECTORY, Context.MODE_PRIVATE)
        file = File(file, "${UUID.randomUUID()}.jpg")

        try {
            val stream : OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        }catch (e:IOException){
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }

    companion object{
        private const val GALLERY = 1
        private const val IMAGE_DIRECTORY = "Paradise"
    }

}