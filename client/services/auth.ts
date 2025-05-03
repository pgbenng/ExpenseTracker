import api from "@/lib/api";
import { AuthResponse, LoginRequest, SignupRequest } from "@/lib/interfaces";

export function signup(req: SignupRequest): Promise<void> {
  return api.post<void>("/api/users/signup", req).then();
}

export function login(req: LoginRequest): Promise<AuthResponse> {
  return api
    .post<AuthResponse>("/api/users/login", req)
    .then((res) => res.data);
}
