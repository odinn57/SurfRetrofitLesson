package dev.surf.retrofitlesson.data.post.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.surf.retrofitlesson.data.post.remote.PostApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PostApiModule {

    @Singleton
    @Provides
    fun providesPostApi(retrofit: Retrofit) = retrofit.create(PostApi::class.java)
}