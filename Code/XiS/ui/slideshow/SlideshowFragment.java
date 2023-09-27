package com.example.xis.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.xis.R;
import com.example.xis.WebViewController;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        WebView webView = root.findViewById(R.id.web_view_contribute);
        webView.loadUrl("https://misreg.nitt.edu/NITTSTUDENT");
        webView.setWebViewClient(new WebViewController());
        return root;
    }
}
