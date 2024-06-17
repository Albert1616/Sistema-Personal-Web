/* eslint-disable react-hooks/rules-of-hooks */
'use client'

import Register from '@/components/login/register'
import { useGenerationStore } from '@/lib/state/stateManagament';
import  {useRouter} from 'next/navigation';
import React from 'react'



function page() {
    const {user, setUser} = useGenerationStore();
    const router = useRouter(); // Access navigation function

    function changePaper(login:string, paper:string){
        setUser(login, paper);
        router.push("/");
    }
    
  return <Register changePaper={changePaper}/>
}

export default page