import { useState, useEffect, useRef } from "react";

function App() {
  const [answer, setAnswer] = useState("");
  const [timer, setTimer] = useState(7);
  const [submitted, setSubmitted] = useState(false);

  const inputRef = useRef(null);

  useEffect(() => {
    inputRef.current.focus();

    const interval = setInterval(() => {
      setTimer((prev) => prev - 1);
    }, 1000);

    return () => clearInterval(interval);
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmitted(true);
    console.log("Answer:", answer);
  };

  const examOver = submitted || timer <= 0;

  return (
    <div>
      {examOver ? (
        <h2>Exam Over</h2>
      ) : (
        <>
          <h2>Time Left: {timer}s</h2>

          <form onSubmit={handleSubmit}>
            <input
              ref={inputRef}
              type="text"
              value={answer}
              onChange={(e) => setAnswer(e.target.value)}
            />

            <button type="submit">
              Submit
            </button>
          </form>
        </>
      )}
    </div>
  );
}

export default App;
