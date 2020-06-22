This project has One-to-One Unidirectional between the Instructor and InstructorDetail.

Both Instructor and InstructorDetail are POJO classes.

Instructor has an instructorId, Firstname, Lastname and an email.
InstructorDetail has an instructorDetailsId, youtube channel link and a hobby.

Both these tables are connected. In the Instructo class I have:

@OneToOne(cascade=CascadeType.ALL)	
@JoinColumn(name="instructor_detail_id")
private InstructorDetail instructorDetail;


Futhermore there are 2 clasees in com.luv2code.hibernate.demo. CreateDemo and Delete Demo. These classes are there to test the OneToOne CascadeType.ALL mappings.

I tested CacadeType.ALL for delete too. When I delted the Instructor entry the corresponding Instructor detail also got deleted.
