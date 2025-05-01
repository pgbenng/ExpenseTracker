import api from "@/lib/api";
import { AuthResponse, LoginRequest, SignupRequest } from "@/lib/interfaces";

export function signup(req: SignupRequest): Promise<void> {
  return api.post<void>("/api/users/signup", req).then();
}

export async function login(req: LoginRequest): Promise<AuthResponse> {
  const res = await api.post<AuthResponse>("/api/users/login", req);
  return res.data;
}
