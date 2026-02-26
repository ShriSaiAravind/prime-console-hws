function Student({ name, marks, id, calculateGrade }) {
  const grade = calculateGrade(marks);

  return (
    <div>
      <h2>Student Details</h2>
      <p>Name: {name}</p>
      <p>Marks: {marks}</p>
      <p>ID: {id}</p>
      <p>Grade: {grade}</p>
    </div>
  );
}

export default Student;
