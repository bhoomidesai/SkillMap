import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const employees = [
      { employee_id: 11, employee_name: 'Bhoomi',password: '123' },
      { employee_id: 12, employee_name: 'Sonam' ,password: '123' }
    ];
    return {employees};
  }
}