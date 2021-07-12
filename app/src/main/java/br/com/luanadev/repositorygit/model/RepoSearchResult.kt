package br.com.luanadev.repositorygit.model

import br.com.luanadev.repositorygit.data.entity.Repo
import java.lang.Exception

sealed class RepoSearchResult {
    data class Success(val data: List<Repo>) : RepoSearchResult()
    data class Error(val error: Exception) : RepoSearchResult()
}