package id.rdev.catatanpenjualan.network
import id.rdev.catatanpenjualan.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkingConfig {
    fun getInterceptor():OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build
    }

    fun service() = getRetrofit().create(CatatanPenjualanService::class.java)
    interface CatatanPenjualanService{

    }
}