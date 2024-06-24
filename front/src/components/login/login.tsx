'use client'

import React, { FormEvent } from 'react'
import {AiOutlineUser} from 'react-icons/ai'
import { useState } from 'react';
import axios from 'axios';
import { useRouter } from 'next/navigation';
import { useAuth } from '../../context/AuthContext'

import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
  } from "@/components/ui/dialog"
import { Input } from '../ui/input'
import { Label } from '../ui/label'
import { Button } from '../ui/button'
import Link from 'next/link'

function Login() {
  const [login, setLogin] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const router = useRouter();
  // const { login: contextLogin } = useAuth();

  const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setError('');

    try {
      console.log({
        login,
        password
      })
      const response = await axios.post('http://localhost:8080/api/user/auth', {
        login,
        password,
      });

      const token = response.data;

      document.cookie = `token=${token}; path=/; HttpOnly; Secure; SameSite=Strict`;
      // router.push('/dashboard');
    } catch (error: any) {
      setError(error?.response?.data?.message || 'Erro ao realizar login');
    }
  };

  return (
    <div className='bg-primaryColor'>
    <Dialog open defaultOpen>
  <DialogContent className='flex flex-col gap-4 px-10 py-7 rounded-md'>
    <DialogHeader>
    <form onSubmit={handleSubmit} className="flex flex-col gap-8">
      <DialogTitle className='flex flex-col items-center justify-center gap-1 mb-3 '><AiOutlineUser size={45}/>Login</DialogTitle>
      <DialogDescription>
        <div className='flex flex-col gap-8'>
            <div>
              <Label htmlFor="login">Login</Label>
              <Input type='text' id='login' placeholder='Digite seu login' value={login} onChange={(e) => setLogin(e.target.value)} className='border-gray-400 rounded-sm mt-1'/>
            </div>
            <div>
              <Label htmlFor="password">Senha</Label>
              <Input type='password' id='password' placeholder='Digite sua senha' value={password} onChange={(e) => setPassword(e.target.value)} className='border-gray-400 rounded-sm mt-1'/>  
            </div>
        </div>
        <div className='flex flex-col gap-2 mt-6'>
            <Button type="submit" className='rounded-md'>Entrar</Button>
            {error && <p>{error}</p>}
            <p>Ainda não tem uma conta? <Link href='/register' className='underline text-primary'>Faça seu cadastro!</Link></p>
        </div>
      </DialogDescription>
      </form>
    </DialogHeader>
  </DialogContent>
</Dialog>

    </div>
      )
}

export default Login