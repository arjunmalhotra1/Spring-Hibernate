In this Project I have worked on how to Lazy Load or Eager Load. 

Eager Load - Will load queried data and rest dependent data from the database at one shot.

Lazy Load- Will load only the queried data and will load the dependent data only once the need arises.

Besides that I also tried 2 options to Lazy Load even after closing the connection, using session.close():

Option 1: Use the GetterMethods before closing the connection to haev the data in the memory.

Option 2: Querying with Hibernate Query language.

