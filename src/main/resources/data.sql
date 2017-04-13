INSERT INTO abac (name, description, type, applicable, condition)
  values('Test Entry', '', null, 'action=="EDIT"', 'subject.principal.age>16');