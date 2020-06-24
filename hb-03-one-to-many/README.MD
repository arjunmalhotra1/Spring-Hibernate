This project has Bi Directional Mapping between the Instructor and InstructorDetail.

Both Instructor and InstructorDetail are POJO classes.

Instructor has an instructorId, Firstname, Lastname and an email.
InstructorDetail has an instructorDetailsId, youtube channel link and a hobby.

Both these tables are connected. In the Instructor class I have:
This below code is sufficient for One-Directional Mapping.
@OneToOne(cascade=CascadeType.ALL)	
@JoinColumn(name="instructor_detail_id")
private InstructorDetail instructorDetail;

For Bi-Directional mapping I have 
@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)
private Instructor instructor;

<<<<<<< HEAD
This will map the Instructor with the Instructor detailsusing the instructorDetail field in the Instructor class(which was used for One directional mapping)

Later changed in the InstructorDetail class
@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)	
private Instructor instructor;

to

Later changed in the InstructorDetail class
@OneToOne(mappedBy="instructorDetail",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})	private Instructor instructor;


This done to test that when I delete the InstructorDetail entry I didn't want to delete the Instructor entry forom my database.
Just by changing this above code and then trying to delete the InstructorDetail entry from the database I faced an eroor, because of the Bi-directional link. For that I had to then first remove the link from the Istructor to the InstructorDetail.

Delete the associated object reference
break bi-directional link
tempInstructorDetail.getInstructor().setInstructorDetail(null);

Basically setting the instructor_detail_id value as null in the Instructor table in the database.
=======
This will map the Instructor with the Instructor detailsusing the instructorDetail field in the Instructor class(whic was used for One directional mapping)

I tested CacadeType.ALL for delete too. When I deleted the Instructor detail entry the corresponding Instructor also got deleted.
Also handled the case for when an id is not in the database the hibernate connections still closes with the finally block.
	
>>>>>>> 203c9f3014e81f3d8cc5f23b18f045bf353b0df9

