Demonstrates AndroidFragment() crash when recreating the parent Fragment


MainActivity (FragmentContainerView)
- FirstTopLevelFragment (ComposeView)
-- NestedInComposeFragment (AndroidFragment)
- SecondTopLevelFragment (ViewBinding) 

1) Navigate from FirstTopLevelFragment -> SecondTopLevelFragment via a Fragment replace() by clicking on the Fab button. 
2) Click back/previous . Observe a crash

<code>
Process: com.example.myapplication, PID: 3643
java.lang.IllegalArgumentException: No view found for id 0x708875b7 (unknown) for fragment NestedInComposeFragment{9df0b2b} (ae4356e1-9543-4636-8326-0c425188d5bd id=0x708875b7 tag=1887991223)
at androidx.fragment.app.FragmentStateManager.createView(FragmentStateManager.java:559)
at androidx.fragment.app.FragmentStateManager.moveToExpectedState(FragmentStateManager.java:278)
at androidx.fragment.app.FragmentStore.moveToExpectedState(FragmentStore.java:114)
at androidx.fragment.app.FragmentManager.moveToState(FragmentManager.java:1663)
at androidx.fragment.app.FragmentManager.dispatchStateChange(FragmentManager.java:3247)
at androidx.fragment.app.FragmentManager.dispatchViewCreated(FragmentManager.java:3158)
at androidx.fragment.app.Fragment.performViewCreated(Fragment.java:3149)
at androidx.fragment.app.FragmentStateManager.createView(FragmentStateManager.java:600)
at androidx.fragment.app.FragmentStateManager.moveToExpectedState(FragmentStateManager.java:278)
at androidx.fragment.app.FragmentManager.executeOpsTogether(FragmentManager.java:2143)
at androidx.fragment.app.FragmentManager.removeRedundantOperationsAndExecute(FragmentManager.java:2047)
at androidx.fragment.app.FragmentManager.popBackStackImmediate(FragmentManager.java:1095)
at androidx.fragment.app.FragmentManager.popBackStackImmediate(FragmentManager.java:984)
at androidx.fragment.app.FragmentManager.handleOnBackPressed(FragmentManager.java:900)
at androidx.fragment.app.FragmentManager$1.handleOnBackPressed(FragmentManager.java:570)
at androidx.activity.OnBackPressedDispatcher.onBackPressed(OnBackPressedDispatcher.kt:276)
at com.example.myapplication.SecondFragment.onViewCreated$lambda$0(SecondFragment.kt:36)
at com.example.myapplication.SecondFragment.$r8$lambda$D56Ez4I3ChfufRinJh-Sz7jy9iI(Unknown Source:0)
at com.example.myapplication.SecondFragment$$ExternalSyntheticLambda0.onClick(D8$$SyntheticClass:0)
at android.view.View.performClick(View.java:7448)
</code>
