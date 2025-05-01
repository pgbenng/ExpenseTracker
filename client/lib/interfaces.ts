export interface LoginRequest {
  email: string;
  password: string;
}

export interface SignupRequest {
  email: string;
  password: string;
  firstName?: string;
}

export interface AuthResponse {
  accessToken: string;
  tokenType: string;
}
