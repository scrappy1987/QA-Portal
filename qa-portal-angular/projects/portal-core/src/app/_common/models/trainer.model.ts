import {UserModel} from './user.model';
import {CohortModel} from './cohort.model';

export class TrainerModel extends UserModel {

  cohorts: CohortModel[];
}
