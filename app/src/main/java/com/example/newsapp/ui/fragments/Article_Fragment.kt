package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class Article_Fragment : Fragment(R.layout.fragment_article) {

//    lateinit var viewModel:NewsViewModel
    var viewModel: NewsViewModel? = null
    val args:Article_FragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as  NewsActivity).viewModel
        val article = args.article

        if (article != null) {
            Log.d("Check from article","${article.author}")
        }else{
            Log.d("Check from article","Null article")
        }

        webView.apply {
            webViewClient = WebViewClient()
            if (article != null) {
                article.url?.let { loadUrl(it) }
            }
        }

        fab.setOnClickListener{
            if (article != null) {
                viewModel!!.saveArticle(article)
            Snackbar.make(view,"Article saved successfully",Snackbar.LENGTH_SHORT).show()


            }
        }


    }
}