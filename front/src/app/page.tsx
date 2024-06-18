'use client';

import { useGenerationStore } from "@/lib/state/stateManagament";
import Login from "@/components/login/login";
import Personal from "@/components/home/personal";
import { useRouter } from "next/navigation";

export default function Home() {
  const {user} = useGenerationStore();
  const {login, paper} = user;

  const router = useRouter();
  
    switch (paper) {
      case 'personal':
        return <Personal />
        break;
      case 'aluno':
        return <div>Aluno</div>
        break;
      case 'nutricionista':
        return <div>Nutricionista</div>
        break; 
      default:
        router.push("/login");
        break;
    }
}
