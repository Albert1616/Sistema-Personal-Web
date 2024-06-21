import React from 'react';
import Image from 'next/image';
import { FaUserAlt } from 'react-icons/fa';
import { Avatar, AvatarFallback, AvatarImage } from '@radix-ui/react-avatar';
import CardAluno from '../aluno/cardAluno';

interface PropsProfissional {
  src: string;
  nome: string;
  funcao: string;
  numAlunos: number;
}

const alunosFicticios = [
  { nome: 'Matheus', email: 'matheus@gmail.com', data: '16/11/2002', icon: '/img/avatar-1.jpg' },
  { nome: 'João', email: 'joao@gmail.com', data: '18/05/2001', icon: '/img/avatar-1.jpg' },
  { nome: 'Maria', email: 'maria@gmail.com', data: '22/09/2003', icon: '/img/avatar-1.jpg' },
  { nome: 'Pedro', email: 'pedro@gmail.com', data: '07/03/2000', icon: '/img/avatar-1.jpg' },
  { nome: 'Ana', email: 'ana@gmail.com', data: '14/12/2004', icon: '/img/avatar-1.jpg' },
  { nome: 'Luiz', email: 'luiz@gmail.com', data: '30/07/1999', icon: '/img/avatar-1.jpg' },
  { nome: 'Mariana', email: 'mariana@gmail.com', data: '05/06/2002', icon: '/img/avatar-1.jpg' },
  { nome: 'Rafaela', email: 'rafaela@gmail.com', data: '19/10/1998', icon: '/img/avatar-1.jpg' },
  { nome: 'Carlos', email: 'carlos@gmail.com', data: '12/04/2001', icon: '/img/avatar-1.jpg' },
  { nome: 'Juliana', email: 'juliana@gmail.com', data: '08/08/2005', icon: '/img/avatar-1.jpg' },
];

function Profissional({ src, nome, funcao, numAlunos }: PropsProfissional) {
  return (
    <div className='grid grid-cols-3 gap-16'>
      <div className='flex flex-col items-center'>
        <Avatar>
          <AvatarImage src={src}/>
          <AvatarFallback>Perfil do profissional</AvatarFallback>
        </Avatar>
        <h1 className='text-3xl font-bold'>{nome}</h1>
        <p className='text-green-400 flex items-center gap-2'><FaUserAlt size={15} />{funcao}</p>
        <p>+ de {numAlunos} alunos</p>
      </div>
      
      <div className='w-full flex flex-col items-center gap-5 col-span-2'>
        <h1 className='text-3xl font-bold'>Alunos</h1>
        <div className='w-full  grid grid-cols-3 gap-8'>
          {alunosFicticios.map((aluno, index) => (
            <CardAluno key={index} nome={aluno.nome} email={aluno.email} data={aluno.data} icon={aluno.icon} />
          ))}
        </div>
      </div>
    </div>
  );
}

export default Profissional;
