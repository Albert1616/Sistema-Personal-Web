import Reac from 'react'
import Image from 'next/image'

// interface pageProps{
//     nome : string,
//     role : string,
//     email: string,
//     data: string,
//     avatar? : string
// }

function page() {
  return (
    // <div className='flex items-center gap-24'>
    //     <Image src='/img/avatar-1' width={200} height={200} alt='Imagem de perfil da conta'/>
    //     <div className='flex flex-col justify-center gap-12'>
    //         <h1>{nome}</h1>
    //         <h3>{role}</h3>
    //         <p>{email}</p>
    //         <p>{data}</p>
    //     </div>
    // </div>
    <div className='flex gap-24 p-5'>
        <Image src='/img/avatar-1.jpg' width={200} height={200} alt='Imagem de perfil da conta'/>
        <div className='flex flex-col justify-center gap-12'>
            <h1 className='text-3xl'>Matheus Albert</h1>
            <h3 className='text-xl text-red-400'>ADM</h3>
        </div>
        <div className='flex flex-col justify-center gap-12'>
            <p>email@email.com</p>
            <p>16/11/2002</p>
        </div>
        
    </div>
  )
}

export default page