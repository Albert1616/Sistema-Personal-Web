import Image from "next/image";
import { Button } from "@/components/ui/button"
import Link from "next/link";
import FormAluno from "@/components/formAluno";


export default function Home() {
  return (
    <main className="min-h-screen py-5 px-7 bg-background">
      <div className="flex gap-3">
        <Button className="bg-ButtonColor p-4 text-white rounded-sm hover:bg-ButtonHoverColor">
          <Link href='/FormAluno'>Adicionar aluno</Link>
        </Button>
        <Button className="bg-ButtonColor p-4 rounded-sm text-white hover:bg-ButtonHoverColor">Exercícios</Button>
        <FormAluno />
      </div>
    </main>
  );
}
