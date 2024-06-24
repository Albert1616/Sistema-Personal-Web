'use client';

import { useGenerationStore } from "@/lib/state/stateManagament";
import Personal from "@/components/home/personal";
import { useRouter } from "next/navigation";
import Aluno from "@/components/home/aluno";

export default function Home() {
  const {user} = useGenerationStore();
  const {login, paper} = user;

  console.log(user)

  const router = useRouter();
  
    switch (paper) {
      case 'personal':
        return <Personal />
        break;
      case 'aluno':
        return <Aluno />
        break;
      case 'nutricionista':
        return <div>Nutricionista</div>
        break; 
      default:
        router.push("/login");
        break;
    }
}
