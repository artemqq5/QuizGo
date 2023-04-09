package gog.quizeog.goeziuq.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gog.quizeog.goeziuq.data.DefaultRepository
import gog.quizeog.goeziuq.data.DefaultRepositoryImp
import gog.quizeog.goeziuq.data.subData.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleRepository {

    @Provides
    @Singleton
    fun provideUserRepository(
        biology: Biology,
        history: History,
        programming: Programming,
        math: Mathem,
        cinema: Cinema,
    ): DefaultRepository {
        return DefaultRepositoryImp(
            biology,
            history,
            programming,
            math,
            cinema,
        )
    }

}