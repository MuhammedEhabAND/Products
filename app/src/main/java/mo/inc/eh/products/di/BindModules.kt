package mo.inc.eh.products.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mo.inc.eh.products.data.local.LocalSource
import mo.inc.eh.products.data.local.LocalSourceImp
import mo.inc.eh.products.data.remote.RemoteSource
import mo.inc.eh.products.data.remote.RemoteSourceImp
import mo.inc.eh.products.data.repo.RepoImp
import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract  class BindModules {
    @Binds
    abstract fun bindRepo(
        repoImp: RepoImp
    ):Repo

    @Binds
    abstract fun bindRemoteSource(
        remoteSourceImp: RemoteSourceImp
    ): RemoteSource

    @Binds
    abstract fun bindLocalSource(
        localSourceImp: LocalSourceImp
    ): LocalSource

}