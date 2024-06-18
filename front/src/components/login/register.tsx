/* eslint-disable react-hooks/rules-of-hooks */
'use client'

import React, { useState } from 'react'

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
import { buttonVariants } from '../ui/button'
import Link from 'next/link'
import { AiOutlineUser } from 'react-icons/ai'
import { useGenerationStore } from '@/lib/state/stateManagament'
import { useRouter } from 'next/router'

interface PropsRegister{
    changePaper: (login:string, paper:string) => void;
}

function register({changePaper} : PropsRegister) {
    return (
    <div>
        <Dialog open>
            <DialogContent className="flex flex-col gap-4 px-10 py-7 rounded-md">
                <DialogHeader>
                    <DialogTitle className='flex flex-col items-center'>
                    <AiOutlineUser size={45}/> Crie Sua Conta
                    </DialogTitle>
                    <DialogDescription>
                        <Label htmlFor="username">Login</Label>
                        <div className='flex flex-col gap-5'>
                        <Input type='text'id='username' className='border-gray-400 rounded-sm'/>
                        <Select>
                        <SelectTrigger className="w-[180px]">
                            <SelectValue placeholder="O que você é?" />
                        </SelectTrigger>
                        <SelectContent>
                            <SelectItem value="aluno">Aluno</SelectItem>
                            <SelectItem value="personal">Personal</SelectItem>
                            <SelectItem value="nutri">Nutricionista</SelectItem>
                        </SelectContent>
                        </Select>
                        <Label htmlFor="password">Digite sua senha</Label>
                        <Input type='password' id='password' className='border-gray-400 rounded-sm'/>
                        <Label htmlFor="password_redigt">Digite novamente a sua senha</Label>
                        <Input type='password' id='password_redgit' className='border-gray-400 rounded-sm'/>    
                        </div>
                        <div className='flex flex-col items-center mt-6 '>
                            <Link href="/" className={buttonVariants({variant:'default'})} onClick={()=>changePaper("albert", "personal")}>Criar conta</Link>
                        </div>
                    </DialogDescription>
                </DialogHeader>
            </DialogContent>
        </Dialog>
    </div>
  )
}

export default register