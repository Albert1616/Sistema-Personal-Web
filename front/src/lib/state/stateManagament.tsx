import {create} from 'zustand'

interface User{
    login: string,
    paper: string
}

interface Aluno{
    nome:string,
    email:string,
    data_nascimento:string,
}

interface GenerationState{
    user:User
    setUser:(login:string,paper:string)=>void,
    lst_aluno: Aluno[],
    setLst:(aluno:Aluno)=>void
}

export const useGenerationStore = create<GenerationState>()((set) =>({
    user:{
        login:'albert',
        paper:'personal'
    },
    setUser: (login: string,paper: string) => set({user: {login, paper}}),
    lst_aluno:[
        {
            nome:"Matheus",
            email:"matheus@email",
            data_nascimento:"16/11/2002"
        },
        {
            nome:"Albert",
            email:"albert@email",
            data_nascimento:"10/10/2010"
        },
        {
            nome:"Paulo",
            email:"paulo@email",
            data_nascimento:"15/08/2008"
        },
    ],
    setLst(aluno){
        this.lst_aluno.push(aluno);
    }
}))