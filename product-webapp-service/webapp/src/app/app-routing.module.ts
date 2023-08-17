import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SlotComponent } from './slot/slot.component';
import { GroundListComponent } from './ground-list/ground-list.component'; // Import the GroundListComponent
import { ArenaDetailsComponent } from './arena-details/arena-details.component';





const routes: Routes = [
  { path: '', component: ArenaDetailsComponent },

  { path: 'arenas', component: GroundListComponent },
  { path: 'arena-details/:id', component: ArenaDetailsComponent },
  {path:'login', component:LoginComponent},
  {path:'signup', component:SignupComponent},
  {path:'slot',component:SlotComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { 
  
}

