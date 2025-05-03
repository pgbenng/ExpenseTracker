"use client";

import { signOut } from "@/services/auth";
import { useRouter } from "next/navigation";

export default function Home() {
  const router = useRouter();

  async function handleSignOut() {
    await signOut();
    router.push("/login");
  }

  return (
    <div>
      <p>Home</p>
      <button onClick={handleSignOut}>Sign out</button>
    </div>
  );
}
