package com.pp.newsapiclient

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.pp.newsapiclient.databinding.FragmentInfoBinding
import com.pp.newsapiclient.presentation.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {
    private lateinit var fragmentInfoBinding: FragmentInfoBinding
    private val viewModel by activityViewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedArticle
        Log.d(
            "Hanuman TAG",
            " CONTENT: ${article.content} TITLE: ${article.title} " +
                    "CONTENT: ${article.description}  PUBLISHED AT: ${article.publishedAt}  AUTHOR: ${article.author}  SOURCE: ${article.source} "
        )



//        fragmentInfoBinding.wvInfo.apply {
//          webViewClient = WebViewClient()
//          if(article.url!=null) {
//              loadUrl(article.url)
//          }
//
//        }
        fragmentInfoBinding.fabSave.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Saved Successfully!", Snackbar.LENGTH_LONG).show()
        }
    }
}







