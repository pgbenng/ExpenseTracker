"use client";

import { FormEvent, useState } from "react";
import { login } from "@/services/auth";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState<string | null>(null);

  async function handleLogin(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setMessage(null);

    try {
      const res = await login({ email, password });
      setMessage("Success!");
    } catch (e) {
      setMessage("Login failed!");
    }
  }

  return (
    <>
      <form onSubmit={handleLogin}>
        <h2>Login</h2>
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
