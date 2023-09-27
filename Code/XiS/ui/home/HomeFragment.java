package com.example.xis.ui.home;

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
import com.example.xis.ui.home.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Created a WebView and used the loadurl method to give url to WebViewController class
        WebView webView = root.findViewById(R.id.web_view_home);
        webView.loadUrl("https://students.nitt.edu/"); // Url of portal is passed
        webView.setWebViewClient(new WebViewController()); // WebViewController is used
        return root;
    }
}
