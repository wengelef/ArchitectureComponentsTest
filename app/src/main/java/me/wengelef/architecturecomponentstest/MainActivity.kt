package me.wengelef.architecturecomponentstest

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import me.wengelef.architecturecomponentstest.service.GithubRepoService
import javax.inject.Inject

class MainActivity : LifecycleActivity() {

    @Inject lateinit var repoService: GithubRepoService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)
    }
}
