"use client";

import { FormEvent, useState } from "react";
import { login } from "@/services/auth";
import { useRouter } from "next/navigation";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState<string | null>(null);
  const router = useRouter();

  async function handleLogin(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setMessage(null);

    try {
      await login({ email, password });
      setMessage("Success!");
      setTimeout(() => router.push("/"), 500);
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
