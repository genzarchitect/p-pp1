import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GroundListComponent } from './ground-list/ground-list.component'; // Import the GroundListComponent
import { ArenaDetailsComponent } from './arena-details/arena-details.component';

const routes: Routes = [
  { path: '', component: ArenaDetailsComponent },

  { path: 'arenas', component: GroundListComponent },
  { path: 'arena-details/:id', component: ArenaDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
