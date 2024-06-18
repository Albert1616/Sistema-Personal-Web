'use client'

import Link from "next/link";
import { buttonVariants } from "./ui/button";
import { Input } from "./ui/input";
import { Label } from "./ui/label";

import { SiReacthookform } from "react-icons/si";
import { useState } from "react";
import { useGenerationStore } from "@/lib/state/stateManagament";

interface formValues{
  nome:string,
  email:string,
  data_nascimento:string
}

export default function FormAluno() {
  const {setLst} = useGenerationStore();
  
  const [formValues, setFormValues] = useState<formValues>({
    nome:'',
    email:'',
    data_nascimento:''
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>, fieldName: keyof formValues) => {
    const { value } = e.target;
    setFormValues({
        ...formValues,
        [fieldName]: value
    });
};

  const addAluno = (formValues: formValues) =>{
    setLst(formValues);

  }

  return (
    <form action="" className="h-full w-[25%] flex flex-col justify-center">
        <div className="flex flex-col gap-5">
          <h2 className="flex items-center justify-center gap-2 text-xl"><SiReacthookform size={25}/> Cadastrar novo aluno</h2>
          <div className="gap-1">
            <Label htmlFor="nome">Nome</Label>
            <Input type="text" value={formValues.nome} onChange={(e)=>handleChange(e, 'nome')}/>
          </div>
          <div className="gap-1">
            <Label htmlFor="email">Email</Label>
            <Input type="email" value={formValues.email} onChange={(e)=>handleChange(e, 'email')}/>
          </div>
          <div className="gap-1 mb-4">
            <Label htmlFor="data">Data de nascimento</Label>
            <Input type="date" value={formValues.data_nascimento} onChange={(e)=>handleChange(e, 'data_nascimento')}/>
          </div>
          <Link href='/' className={buttonVariants({variant:"default"})} onClick={()=>addAluno(formValues)}>Adicionar</Link>
        </div>
    </form>
  );
}
