// store/tokenStore.ts
import { create } from 'zustand';
import jwt_decode from 'jwt-decode';

interface TokenPayload {
  sub: string;
  nome: string;
  email: string;
  exp: number; // Timestamp de expiração
}

interface TokenState {
  token: string | null;
  tokenPayload: TokenPayload | null;
  setToken: (token: string) => void;
  clearToken: () => void;
}

export const useTokenStore = create<TokenState>()((set) => {
  const initialToken = localStorage.getItem('authToken') || null;
  const initialPayload = initialToken ? jwt_decode<TokenPayload>(initialToken) : null;

  return {
    token: initialToken,
    tokenPayload: initialPayload,
    setToken: (token: string) => {
      localStorage.setItem('authToken', token);
      const decodedToken = jwt_decode<TokenPayload>(token);
      set({ token, tokenPayload: decodedToken });
    },
    clearToken: () => {
      localStorage.removeItem('authToken');
      set({ token: null, tokenPayload: null });
    },
  };
});
