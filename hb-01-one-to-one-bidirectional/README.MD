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

This will map the Instructor with the Instructor detailsusing the instructorDetail field in the Instructor class(whic was used for One directional mapping)
	

