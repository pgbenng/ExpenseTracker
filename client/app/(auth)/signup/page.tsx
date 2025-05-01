"use client";

import { FormEvent, useState } from "react";
import { signup } from "@/services/auth";

export default function Signup() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [message, setMessage] = useState<string | null>(null);

  async function handleSignup(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setMessage(null);

    try {
      await signup({ email, password, firstName });
      setMessage("Success!");
    } catch (e) {
      setMessage("Sign up error!");
    }
  }

  return (
    <>
      <form onSubmit={handleSignup}>
        <h2>Sign Up</h2>
        <input type={"text"} onChange={(e) => setFirstName(e.target.value)} />
        <input type={"email"} onChange={(e) => setEmail(e.target.value)} />
        <input
          type={"password"}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button>Submit</button>
        {message && <p style={{ color: "red" }}>{message}</p>}
      </form>
    </>
  );
}
