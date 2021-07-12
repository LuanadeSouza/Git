package br.com.luanadev.repositorygit

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import br.com.luanadev.repositorygit.api.GithubService
import br.com.luanadev.repositorygit.data.GithubRepository
import br.com.luanadev.repositorygit.data.db.repo.RepoDatabase
import br.com.luanadev.repositorygit.ui.ViewModelFactory

object Injection {

    private fun provideGithubRepository(context: Context): GithubRepository {
        return GithubRepository(GithubService.create(), RepoDatabase.getInstance(context))
    }
    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideGithubRepository(context))
    }
}