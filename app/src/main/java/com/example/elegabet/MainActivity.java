    package com.example.elegabet;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.appcompat.app.ActionBarDrawerToggle;
    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.os.Handler;
    import android.view.MenuItem;
    import android.view.View;

    import androidx.core.view.GravityCompat;
    import androidx.drawerlayout.widget.DrawerLayout;
    import androidx.appcompat.widget.Toolbar;
    import androidx.navigation.NavController;
    import androidx.navigation.NavDestination;
    import androidx.navigation.Navigation;
    import androidx.navigation.fragment.NavHostFragment;
    import androidx.navigation.ui.AppBarConfiguration;
    import androidx.navigation.ui.NavigationUI;

    import com.example.elegabet.R;
    import com.example.elegabet.databinding.ActivityMainBinding;

    public class MainActivity extends AppCompatActivity {

        private static final long AUTO_NAVIGATION_DELAY = 2000;
        private static final int[] CHARGING_SCREEN_FRAGMENTS = {
                R.id.chargingScreenFragment,
                R.id.chargingScreenFragment1,
                R.id.chargingScreenFragment2,
                R.id.chargingScreenFragment3,
                R.id.chargingScreenFragment4,
                R.id.chargingScreenFragment5,
                R.id.homeFragment
        };

        private Handler handler;
        private int currentFragmentIndex = 0;

        @Override
        protected void onDestroy() {
            super.onDestroy();
            // Detener cualquier acción pendiente cuando se destruye la actividad
            handler.removeCallbacksAndMessages(null);
        }

        private void navigateToNextFragment() {
            if (currentFragmentIndex < CHARGING_SCREEN_FRAGMENTS.length) {
                // Obtener el NavController desde el NavHostFragment
                NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                NavController navController = navHostFragment.getNavController();

                // Navegar al siguiente fragmento
                navController.navigate(CHARGING_SCREEN_FRAGMENTS[currentFragmentIndex]);

                // Incrementar el índice del fragmento actual para la siguiente navegación
                currentFragmentIndex++;

                // Programar la siguiente navegación después del retraso
                handler.postDelayed(this::navigateToNextFragment, AUTO_NAVIGATION_DELAY);
            }
        }


        private DrawerLayout drawer;
        private ActionBarDrawerToggle toggle;
        private Toolbar toolbar;

        ActivityMainBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

            // Configurar la barra de herramientas (Toolbar)
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();

            NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
            NavigationUI.setupWithNavController(binding.toolbar, navController);


            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                @Override
                public void onDestinationChanged(@NonNull NavController controller,
                                                 @NonNull NavDestination destination, @Nullable Bundle arguments) {
                    int destinationId = destination.getId();
                    if (destinationId == R.id.chargingScreenFragment ||
                            destinationId == R.id.chargingScreenFragment1 ||
                            destinationId == R.id.chargingScreenFragment2 ||
                            destinationId == R.id.chargingScreenFragment3 ||
                            destinationId == R.id.chargingScreenFragment4 ||
                            destinationId == R.id.chargingScreenFragment5 ) {
                        binding.bottomNavigation.setVisibility(View.GONE);
                        binding.toolbar.setVisibility(View.GONE);
                    } else {
                        binding.bottomNavigation.setVisibility(View.VISIBLE);
                        binding.toolbar.setVisibility(View.VISIBLE);
                    }
                }
            });


            // Iniciar navegación automática entre los fragmentos
            handler = new Handler();
            navigateToNextFragment();
        }

    }