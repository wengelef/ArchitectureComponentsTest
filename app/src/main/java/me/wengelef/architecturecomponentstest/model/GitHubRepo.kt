package me.wengelef.architecturecomponentstest.model

data class GitHubRepo(
        val id: Long,
        val name: String,
        val full_name: String,
        val owner: GitHubUser,
        val private: Boolean,
        val html_url: String,
        val description: String,
        val url: String,
        val created_at: String,
        val updated_at: String,
        val pushed_at: String,
        val language: String
)