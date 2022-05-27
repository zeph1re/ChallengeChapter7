package binar.ganda.challengechapter7.di

import binar.ganda.challengechapter7.network.MovieService
import dagger.Component


@Component(modules = [MovieApiModule::class])
interface MovieApiComponent {
    fun injectService(service: MovieService)
}