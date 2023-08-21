import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SlotComponent } from './slot/slot.component';
import { GroundListComponent } from './ground-list/ground-list.component'; // Import the GroundListComponent
import { ArenaDetailsComponent } from './arena-details/arena-details.component';
import { ProfileComponent } from './profile/profile.component';
import { GroundOwnerComponent } from './ground-owner/ground-owner.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { OwnerhistoryComponent } from './ownerhistory/ownerhistory.component';

const routes: Routes = [
  { path: '', component: ArenaDetailsComponent },

  { path: 'arenas', component: GroundListComponent },
  { path: 'arena-details/:id', component: ArenaDetailsComponent },
  { path: 'addground', component: GroundOwnerComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'slot', component: SlotComponent },
  { path: 'profile', component: ProfileComponent },
  {path:'playerdetails',component:OrderhistoryComponent},
  {path:'bookings',component:OwnerhistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
