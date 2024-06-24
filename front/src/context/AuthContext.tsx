// context/AuthContext.tsx
import { createContext, useContext } from 'react';
import { useTokenStore } from '../store/tokenStore';
import { useEffect } from 'react';

const AuthContext = createContext<TokenState | undefined>(undefined);

export const AuthProvider = ({ children }) => {
  const tokenState = useTokenStore();
  const { tokenPayload, clearToken } = tokenState;

  useEffect(() => {
    const checkTokenExpiration = () => {
      if (tokenPayload && tokenPayload.exp < Date.now() / 1000) {
        clearToken();
      }
    };

    checkTokenExpiration();
    const intervalId = setInterval(checkTokenExpiration, 5 * 60 * 1000); // Verifica a cada 5 minutos
    return () => clearInterval(intervalId);
  }, [tokenPayload, clearToken]);

  return <AuthContext.Provider value={tokenState}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};
