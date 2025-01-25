package com.sifat.thenotesapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.sifat.thenotesapp.database.NoteDatabase
import com.sifat.thenotesapp.databinding.ActivityMainBinding
import com.sifat.thenotesapp.repesitory.NoteRepository
import com.sifat.thenotesapp.viewModel.NoteViewModel
import com.sifat.thenotesapp.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewModel()
    }

    private fun setUpViewModel(){
        val noteRepository = NoteRepository(NoteDatabase.getInstance(this)) // সিঙ্গেলটন ইনস্ট্যান্স
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}
