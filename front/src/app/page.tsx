'use client';

import { useGenerationStore } from "@/lib/state/stateManagament";
import Login from "@/components/login/login";
import Personal from "@/components/home/personal";


export default function Home() {
  const {user} = useGenerationStore();
  const {login, paper} = user;
  
    switch (paper) {
      case 'aluno':
        return <Personal />
        break;
      case 'personal':
        return <div>Personal</div>
        break;
      case 'nutricionista':
        return <div>Nutricionista</div>
        break; 
      default:
        return <Login />
        break;
    }
}
