import {create} from 'zustand'

interface User{
    login: string,
    paper: string
}

interface GenerationState{
    user:User
    setUser:(login:string,paper:string)=>void,
}

export const useGenerationStore = create<GenerationState>()((set) =>({
    user:{
        login:'albert',
        paper:'anonimo'
    },
    setUser: (login: string,paper: string) => set({user: {login, paper}}),
}))