package binar.ganda.challengechapter7.di

import androidx.fragment.app.ListFragment
import dagger.Component


@Component (modules = [MovieApiModule::class])
interface ViewModelComponent {
    fun inject(viewModel : ListFragmentViewModel)
}