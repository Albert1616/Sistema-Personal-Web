/* eslint-disable react-hooks/rules-of-hooks */
'use client'

import React, { FormEvent, useState } from 'react'

import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
  } from "@/components/ui/dialog"

import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
  } from "@/components/ui/select"
  
import { Input } from '../ui/input'
import { Label } from '../ui/label'
import { Button, buttonVariants } from '../ui/button'
import Link from 'next/link'
import { AiOutlineUser } from 'react-icons/ai'
import { useGenerationStore } from '@/lib/state/stateManagament'
import { useRouter } from 'next/navigation'
import axios, { AxiosResponse } from 'axios'

function register() {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const [paper, setPaper] = useState('');
    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');


    const [error, setError] = useState('');
    const router = useRouter();
    // const { login: contextLogin } = useAuth();

    async function handleSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault()
        setError('')

        try {
            console.log({
                nome,
                email,
                dataNascimento,
                paper,
                login,
                password
            })

            let response: any;

            switch (paper) {
                case "NUTRICIONISTA":
                    response = await axios.post('http://localhost:8080/api/nutricionista/cadaster', {
                        nome,
                        email,
                        dataNascimento,
                        paper,
                        login,
                        password
                    });
                    break;
                case "PERSONAL":
                    response = await axios.post('http://localhost:8080/api/personal/cadaster', {
                        nome,
                        email,
                        dataNascimento,
                        paper,
                        login,
                        password
                    });
                    break;

                case "ALUNO":
                    response = await axios.post('http://localhost:8080/api/aluno/cadaster', {
                        nome,
                        email,
                        dataNascimento,
                        paper,
                        login,
                        password
                    });
                    break;
                default:
;
            }
            
            console.log(response.data)
            router.push('/login');
        } catch (error: any) {
            setError(error?.response?.data?.message || 'Erro ao realizar cadastro')
        }
    }

    return (
    <div>
        <Dialog open>
            <DialogContent className="flex flex-col gap-4 px-10 py-7 rounded-md">
                <DialogHeader>
                    <form className='flex flex-col gap-8' onSubmit={handleSubmit}>
                        <DialogTitle className='flex flex-col items-center'>
                        <AiOutlineUser size={45}/> Crie Sua Conta
                        </DialogTitle>
                        <DialogDescription>
                            <div className='flex flex-col gap-5'>
                            <div>
                                <Label htmlFor="nome">Nome</Label>
                                <Input type='text' id='nome' className='border-gray-400 rounded-sm mt-1' value={nome} onChange={(e) => setNome(e.target.value)} required/>
                            </div>
                            <div>
                                <Label htmlFor="email">Email</Label>
                                <Input type='email' id='email' className='border-gray-400 rounded-sm mt-1' value={email} onChange={(e) => setEmail(e.target.value)} required/>
                            </div>
                            <div>
                                <Label htmlFor="dataNascimento">Data de nascimento</Label>
                                <Input type='date' id='dataNascimento' className='border-gray-400 rounded-sm mt-1' value={dataNascimento} onChange={(e) => setDataNascimento(e.target.value)}/>
                            </div>
                            <div>
                                <Select value={paper} onValueChange={setPaper} required>
                                    <SelectTrigger className="w-[180px]">
                                        <SelectValue placeholder="O que você é?" />
                                    </SelectTrigger>
                                    <SelectContent>
                                        <SelectItem value="ALUNO">Aluno</SelectItem>
                                        <SelectItem value="PERSONAL">Personal</SelectItem>
                                        <SelectItem value="NUTRICIONISTA">Nutricionista</SelectItem>
                                    </SelectContent>
                                </Select>
                            </div>
                            <div>
                                <Label htmlFor="username">Login</Label>
                                <Input type='text' id='username' className='border-gray-400 rounded-sm mt-1' value={login} onChange={(e) => setLogin(e.target.value)} required/>
                            </div>
                            <div>
                                <Label htmlFor="password">Senha</Label>
                                <Input type='password' id='password' className='border-gray-400 rounded-sm mt-1' value={password} onChange={(e) => setPassword(e.target.value)} required/>
                            </div>
                            </div>
                            <div className='flex flex-col items-center mt-6'>
                                <Button type="submit" className='rounded-md'>Criar conta</Button>
                                {/* {error && <p>{error}</p>} */}
                                <p className='mt-4'>Já possui uma conta? <Link href='/login' className='underline text-primary'>Clique aqui para entrar.</Link></p>
                            </div>
                        </DialogDescription>
                    </form>
                </DialogHeader>
            </DialogContent>
        </Dialog>
    </div>
  )
}

export default register