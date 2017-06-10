package me.wengelef.architecturecomponentstest.service

import me.wengelef.architecturecomponentstest.model.GitHubRepo
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface GithubRepoService {

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Observable<List<GitHubRepo>>
}